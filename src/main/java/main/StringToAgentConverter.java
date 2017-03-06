package main;

import data.Agent;

public class StringToAgentConverter {
    private static final String EMPTY_STRING_ERROR_MESSAGE =
            "Breed field of the input file is empty";
    private static final String NOT_A_NUMBER_ERROR_MESSAGE =
            "Some numeric fields of the input file are not numbers: ";

    public Agent convertStringToAgent(String string) {
        String[] fields = string.split(",");
        String agentBreed = fields[0];
        if (agentBreed.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
        }
        boolean autoRenew = false;
        try {
            if (Integer.parseInt(fields[8]) == 1) {
                autoRenew = true;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR_MESSAGE + e.getMessage());
        }
        try {
            return new Agent
                    .Builder()
                    .setAgentBreed(agentBreed)
                    .setPolicyId(Long.parseLong(fields[1]))
                    .setAge(Integer.parseInt(fields[2]))
                    .setSocialGrade(Integer.parseInt(fields[3]))
                    .setPaymentAtPurchase(Integer.parseInt(fields[4]))
                    .setAttributeBrand(Double.parseDouble(fields[5]))
                    .setAttributePrice(Double.parseDouble(fields[6]))
                    .setAttributePromotions(Double.parseDouble(fields[7]))
                    .setAutoRenew(autoRenew)
                    .setInertiaForSwitch(Integer.parseInt(fields[9]))
                    .build();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR_MESSAGE + e.getMessage());
        }

    }
}
