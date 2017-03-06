package data;

public class Result {
    private int breedCAgentsNumber;
    private int breedNCAgentsNumber;
    private int lostBreedCNumber;
    private int gainedBreedCNumber;
    private int regainedBreedCNumber;

    public int getBreedCAgentsNumber() {
        return breedCAgentsNumber;
    }

    public int getBreedNCAgentsNumber() {
        return breedNCAgentsNumber;
    }

    public int getLostBreedCNumber() {
        return lostBreedCNumber;
    }

    public int getGainedBreedCNumber() {
        return gainedBreedCNumber;
    }

    public int getRegainedBreedCNumber() {
        return regainedBreedCNumber;
    }

    public static class Builder {
        private int breedCAgentsNumber;
        private int breedNCAgentsNumber;
        private int lostBreedCNumber;
        private int gainedBreedCNumber;
        private int regainedBreedCNumber;

        public Builder setBreedCAgentsNumber(int breedCAgentsNumber) {
            this.breedCAgentsNumber = breedCAgentsNumber;
            return this;
        }

        public Builder setBreedNCAgentsNumber(int breedNCAgentsNumber) {
            this.breedNCAgentsNumber = breedNCAgentsNumber;
            return this;
        }

        public Builder setLostBreedCNumber(int lostBreedCNumber) {
            this.lostBreedCNumber = lostBreedCNumber;
            return this;
        }

        public Builder setGainedBreedCNumber(int gainedBreedCNumber) {
            this.gainedBreedCNumber = gainedBreedCNumber;
            return this;
        }

        public Builder setRegainedBreedCNumber(int regainedBreedCNumber) {
            this.regainedBreedCNumber = regainedBreedCNumber;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }

    public Result(Builder builder) {
        this.breedCAgentsNumber = builder.breedCAgentsNumber;
        this.breedNCAgentsNumber = builder.breedNCAgentsNumber;
        this.lostBreedCNumber = builder.lostBreedCNumber;
        this.gainedBreedCNumber = builder.gainedBreedCNumber;
        this.regainedBreedCNumber = builder.regainedBreedCNumber;
    }

    @Override
    public String toString() {
        return "Result{" +
                "breedCAgentsNumber=" + breedCAgentsNumber +
                ", breedNCAgentsNumber=" + breedNCAgentsNumber +
                ", lostBreedCNumber=" + lostBreedCNumber +
                ", gainedBreedCNumber=" + gainedBreedCNumber +
                ", regainedBreedCNumber=" + regainedBreedCNumber +
                '}';
    }
}
