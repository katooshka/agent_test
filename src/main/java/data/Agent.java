package data;

public class Agent {
    private String agentBreed;
    private long policyId;
    private int age;
    private int socialGrade;
    private int paymentAtPurchase;
    private double attributeBrand;
    private double attributePrice;
    private double attributePromotions;
    private boolean autoRenew;
    private int inertiaForSwitch;

    public String getAgentBreed() {
        return agentBreed;
    }

    public long getPolicyId() {
        return policyId;
    }

    public int getAge() {
        return age;
    }

    public int getSocialGrade() {
        return socialGrade;
    }

    public int getPaymentAtPurchase() {
        return paymentAtPurchase;
    }

    public double getAttributeBrand() {
        return attributeBrand;
    }

    public double getAttributePrice() {
        return attributePrice;
    }

    public double getAttributePromotions() {
        return attributePromotions;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public int getInertiaForSwitch() {
        return inertiaForSwitch;
    }

    public static class Builder {
        private String agentBreed;
        private long policyId;
        private int age;
        private int socialGrade;
        private int paymentAtPurchase;
        private double attributeBrand;
        private double attributePrice;
        private double attributePromotions;
        private boolean autoRenew;
        private int inertiaForSwitch;

        public Builder setAgentBreed(String agentBreed) {
            this.agentBreed = agentBreed;
            return this;
        }

        public Builder setPolicyId(long policyId) {
            this.policyId = policyId;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSocialGrade(int socialGrade) {
            this.socialGrade = socialGrade;
            return this;
        }

        public Builder setPaymentAtPurchase(int paymentAtPurchase) {
            this.paymentAtPurchase = paymentAtPurchase;
            return this;
        }

        public Builder setAttributeBrand(double attributeBrand) {
            this.attributeBrand = attributeBrand;
            return this;
        }

        public Builder setAttributePrice(double attributePrice) {
            this.attributePrice = attributePrice;
            return this;
        }

        public Builder setAttributePromotions(double attributePromotions) {
            this.attributePromotions = attributePromotions;
            return this;
        }

        public Builder setAutoRenew(boolean autoRenew) {
            this.autoRenew = autoRenew;
            return this;
        }

        public Builder setInertiaForSwitch(int inertiaForSwitch) {
            this.inertiaForSwitch = inertiaForSwitch;
            return this;
        }

        public Agent build() {
            return new Agent(this);
        }
    }

    private Agent(Builder builder) {
        this.agentBreed = builder.agentBreed;
        this.policyId = builder.policyId;
        this.age = builder.age;
        this.socialGrade = builder.socialGrade;
        this.paymentAtPurchase = builder.paymentAtPurchase;
        this.attributeBrand = builder.attributeBrand;
        this.attributePrice = builder.attributePrice;
        this.attributePromotions = builder.attributePromotions;
        this.autoRenew = builder.autoRenew;
        this.inertiaForSwitch = builder.inertiaForSwitch;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentBreed='" + agentBreed + '\'' +
                ", policyId=" + policyId +
                ", age=" + age +
                ", socialGrade=" + socialGrade +
                ", paymentAtPurchase=" + paymentAtPurchase +
                ", attributeBrand=" + attributeBrand +
                ", attributePrice=" + attributePrice +
                ", attributePromotions=" + attributePromotions +
                ", autoRenew=" + autoRenew +
                ", inertiaForSwitch=" + inertiaForSwitch +
                '}';
    }
}
