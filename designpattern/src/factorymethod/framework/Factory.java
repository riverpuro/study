package factorymethod.framework;

public abstract class Factory<T extends Product> {
    public final Product create(String owner) {
        T p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public abstract T createProduct(String owner);
    public abstract void registerProduct(T product);
}
