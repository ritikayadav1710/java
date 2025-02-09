class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        System.out.println("Singleton instance created!");
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonLazy!");
    }

    public static void main(String[] args) {
        SingletonLazy singleton = SingletonLazy.getInstance();
        singleton.showMessage();
    }
}
