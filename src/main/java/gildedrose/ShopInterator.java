package gildedrose;

import gildedrose.Items.Repositories.ItemGateway;

public abstract class ShopInterator {

    protected ShopOutputBoundary console = new ShopOutputBoundary();
    protected ItemGateway itemGateway;

    public ShopInterator(ItemGateway itemGateway)
    {
        this.itemGateway = itemGateway;
    }


}
