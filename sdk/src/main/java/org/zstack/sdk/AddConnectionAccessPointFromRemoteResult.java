package org.zstack.sdk;

import org.zstack.sdk.ConnectionAccessPointInventory;

public class AddConnectionAccessPointFromRemoteResult {
    public ConnectionAccessPointInventory inventory;
    public void setInventory(ConnectionAccessPointInventory inventory) {
        this.inventory = inventory;
    }
    public ConnectionAccessPointInventory getInventory() {
        return this.inventory;
    }

}
