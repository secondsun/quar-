package net.saga.quarkey.server.entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PortfolioEntry extends PanacheEntity{

    public String name, description,demoUrl,githubUrl;
}