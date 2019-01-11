package ch.ffhs.devops.musicservice.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class InMemoryRepository<ModelType extends Model> {
    protected final List<ModelType> models = new ArrayList<>();

    public void add(ModelType newModel) {
        models.add(newModel);
    }

    public List<ModelType> all() {
        return models;
    }

    public Optional<ModelType> byId(UUID id) {
        return models
                .stream()
                .filter(model -> model.getId().equals(id))
                .findFirst();
    }

    public void replace(UUID id, ModelType newModel) {
        models.replaceAll(currentModel -> currentModel.getId().equals(id) ? newModel : currentModel);
    }

    public void remove(UUID id) {
        models.removeIf(model -> model.getId().equals(id));
    }
}
