class SingletonThreadSafe {
    private static SingletonThreadSafe instance;

    private SingletonThreadSafe() {
        System.out.println("Singleton instance created!");
    }

    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonThreadSafe!");
    }

    public static void main(String[] args) {
        SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
        singleton.showMessage();
    }
}
