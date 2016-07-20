/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ruogin.optest.common.entities;

/**
 *
 * @author ruogin
 */
public abstract class EntityType {

    // # Entity type specific
    private String _ETName = "Unknown";

    public String getETName() {
        return _ETName;
    }

    // # Global
    private String _Name = "NN";
    private int _Tag = 0;

    public EntityType() {
        this._ETName = this.getClass().getName();
    }

    public abstract int getMaxCount();

}
