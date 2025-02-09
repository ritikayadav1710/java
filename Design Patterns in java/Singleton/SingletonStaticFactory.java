class SingletonStaticFactory {
    private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();

    private SingletonStaticFactory() {
        System.out.println("Singleton instance created!");
    }

    public static SingletonStaticFactory getInstance() {
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonStaticFactory!");
    }

    public static void main(String[] args) {
        SingletonStaticFactory singleton = SingletonStaticFactory.getInstance();
        singleton.showMessage();
    }
}
