class SingletonStaticFinal {
    public static final SingletonStaticFinal INSTANCE = new SingletonStaticFinal();

    private SingletonStaticFinal() {
        System.out.println("Singleton instance created!");
    }

    public void showMessage() {
        System.out.println("Hello from SingletonStaticFinal!");
    }

    public static void main(String[] args) {
        SingletonStaticFinal singleton = SingletonStaticFinal.INSTANCE;
        singleton.showMessage();
    }
}
