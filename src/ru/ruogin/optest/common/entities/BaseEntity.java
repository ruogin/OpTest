/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ruogin.optest.common.entities;

import java.util.HashMap;

/**
 *
 * @author ruogin
 */
public class BaseEntity {

    public BaseEntity getParent() {
        return _Parent;
    }

    public EntityType getEntityType() {
        return _EntityType;
    }
    
    private int _ID = -1; // ID in nearest parent
    private BaseEntity _Owner = null;
    private BaseEntity _Parent = null;
    private EntityType _EntityType = null;
    
    private static HashMap<String, BaseEntity[]> _entityFullLists = new HashMap<>();
    
    public int getID() {
        return _ID;
    }

    public BaseEntity(EntityType ET, BaseEntity BEP, BaseEntity _Owner, boolean hasEntityFast, boolean hasEntityInner) {
        this._EntityType = ET;
        this._Parent = BEP;
        if (this._Owner == null) this._Owner = this;
        if (BaseEntity._entityFullLists == null) BaseEntity._entityFullLists = new HashMap<>();
    }

    public void addToFullLists() {
        if (!BaseEntity._entityFullLists.containsKey(this._EntityType.getETName())) {
            BaseEntity._entityFullLists.put(this._EntityType.getETName(), new BaseEntity[this._EntityType.getMaxCount()]);
        }
    }
    
    public int FindFree() {
        int nID = 0;
        int nAns = -1;
        while (nID < this._EntityType.getMaxCount() && nAns == -1)
        {
            nID++;
            if (BaseEntity._entityFullLists.get(this._EntityType.getETName())[nID] == null) nAns = nID;
        }
        return nAns;
    }
    
    public BaseEntity Init(int ID, BaseEntity BEP) {
        this._ID = ID;
        return this;
    }
}
