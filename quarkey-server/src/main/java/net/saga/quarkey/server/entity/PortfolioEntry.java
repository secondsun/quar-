package net.saga.quarkey.server.entity;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@JsonbPropertyOrder({"id", "name", "description", "githubUrl", "demoUrl"})
public class PortfolioEntry extends PanacheEntity{

    public String name, description,demoUrl,githubUrl;

    @Override
    @JsonIgnore
    @JsonbTransient
    public boolean isPersistent() {
        return super.isPersistent();
    }


}