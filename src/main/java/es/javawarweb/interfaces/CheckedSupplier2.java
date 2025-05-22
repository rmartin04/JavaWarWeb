package es.javawarweb.interfaces;

public interface CheckedSupplier2 {

    @FunctionalInterface
    public interface CheckedSupplier<T> {
        T get() throws Exception;
    }
}
