package main;

import data.Agent;
import data.Result;

import java.util.List;

public class DataProcessor {
    private static final int YEARS_NUMBER = 15;
    private static final String BREED_C = "Breed_C";
    private static final String BREED_NC = "Breed_NC";

    public Result process(List<Agent> agents, double brandFactor) {
        int breedCAgentsNumber = 0;
        int breedNCAgentsNumber = 0;
        int lostBreedCNumber = 0;
        int gainedBreedCNumber = 0;
        int regainedBreedCNumber = 0;

        for (Agent agent : agents) {
            String initialBreed = agent.getAgentBreed();
            if (agent.autoRenew()) {
                if (initialBreed.equals(BREED_C)) {
                    breedCAgentsNumber++;
                } else {
                    breedNCAgentsNumber++;
                }
            } else {
                boolean switchedToBreedNC = false;
                for (int i = 0; i < YEARS_NUMBER; i++) {
                    updateBreedsAgentsNumber(agent, brandFactor);
                    if (initialBreed.equals(BREED_C) && agent.getAgentBreed().equals(BREED_NC)) {
                        switchedToBreedNC = true;
                    }
                }
                String finalBreed = agent.getAgentBreed();
                if (initialBreed.equals(finalBreed)) {
                    if (initialBreed.equals(BREED_C)) {
                        breedCAgentsNumber++;
                        if (switchedToBreedNC) {
                            regainedBreedCNumber++;
                        }
                    } else {
                        breedNCAgentsNumber++;
                    }
                } else {
                    if (initialBreed.equals(BREED_C)) {
                        breedNCAgentsNumber++;
                        lostBreedCNumber++;
                    } else {
                        breedCAgentsNumber++;
                        gainedBreedCNumber++;
                    }
                }
            }
        }
        return new Result
                .Builder()
                .setBreedCAgentsNumber(breedCAgentsNumber)
                .setBreedNCAgentsNumber(breedNCAgentsNumber)
                .setLostBreedCNumber(lostBreedCNumber)
                .setGainedBreedCNumber(gainedBreedCNumber)
                .setRegainedBreedCNumber(regainedBreedCNumber)
                .build();
    }

    private void updateBreedsAgentsNumber(Agent agent, double brandFactor) {
        String initialBreed = agent.getAgentBreed();
        double affinity = agent.getPaymentAtPurchase() / agent.getAttributePrice() +
                (2 * agent.getAttributePromotions() * agent.getInertiaForSwitch());
        if (initialBreed.equals(BREED_C)) {
            if (affinity < agent.getSocialGrade() * agent.getAttributeBrand()) {
                agent.setAgentBreed(BREED_NC);
            }
        } else {
            if (affinity < agent.getSocialGrade() * agent.getAttributeBrand() * brandFactor) {
                agent.setAgentBreed(BREED_C);
            }
        }
    }
}
