class User {
    private String name;
    private String email;
    private int age;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
    }

    public void showUserDetails() {
        System.out.println("User: " + name + ", Email: " + email + ", Age: " + age);
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private int age;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email address");
            }
            if (age < 18) {
                throw new IllegalArgumentException("Age must be at least 18");
            }
            return new User(this);
        }
    }

    public static void main(String[] args) {
        try {
            User user = new User.UserBuilder()
                    .setName("Ritika")
                    .setEmail("ritika@example.com")
                    .setAge(22)
                    .build();

            user.showUserDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
