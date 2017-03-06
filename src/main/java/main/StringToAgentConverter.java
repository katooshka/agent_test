package main;

import data.Agent;

public class StringToAgentConverter {
    private static final int EXPECTED_FIELDS_NUMBER = 10;
    private static final String WRONG_FIELDS_NUMBER_ERROR_MESSAGE =
            "Fields number not as expected";
    private static final String EMPTY_STRING_ERROR_MESSAGE =
            "Breed field of the input file is empty";
    private static final String NOT_A_NUMBER_ERROR_MESSAGE =
            "Some numeric fields of the input file are not numbers: ";

    /**
     * Converts string representing an input CSV file entry into Agent Object. Field are split by
     * comma, so delimiters for input CSV double values should not be equal to comma.
     *
     * @param string input file entry
     * @return file entry info in a form of Agent Object
     * @throws IllegalArgumentException if input file fields are in wrong format
     */
    public Agent convertStringToAgent(String string) {
        String[] fields = string.split(",");
        if (fields.length != EXPECTED_FIELDS_NUMBER) {
            throw new IllegalArgumentException(WRONG_FIELDS_NUMBER_ERROR_MESSAGE);
        }
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
