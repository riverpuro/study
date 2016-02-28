package factorymethod.idcard;

import factorymethod.framework.Factory;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory<IDCard> {
    private List<String> owners = new ArrayList<String>();
    private int latestSerial = 1;

    @Override
    public IDCard createProduct(String owner) {
        return new IDCard(owner, latestSerial++);
    }

    @Override
    public void registerProduct(IDCard product) {
        owners.add(product.getOwner());
    }

    public List<String> getOwners() {
        return owners;
    }
}
