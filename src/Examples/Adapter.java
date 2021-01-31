package Examples;

public class Adapter {
    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getPhoneNumber() {
            return data.getPhoneNumber();
        }
    }

    public static interface Contact {
        String getPhoneNumber();
    }
    public static interface Customer {
        String getCompanyName();
    }
    public static interface IncomeData {
        String getCompany();
        String getPhoneNumber();
    }
}