public class Main {
    public enum type {
        PRIVATE,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public static void main(String[] args) {
        System.out.println(type.FRIDAY);
    }
}
