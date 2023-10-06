package RiEZAS.domain.models;

import java.util.UUID;

public class BaseModel {

    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
