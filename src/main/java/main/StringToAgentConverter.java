package main;

import data.Agent;

public class StringToAgentConverter {

    //TODO: add fields validation
    public Agent convertStringToAgent(String string) {
        String[] fields = string.split(",");
        return new Agent
                .Builder()
                .setAgentBreed(fields[0])
                .setPolicyId(Long.parseLong(fields[1]))
                .setAge(Integer.parseInt(fields[2]))
                .setSocialGrade(Integer.parseInt(fields[3]))
                .setPaymentAtPurchase(Integer.parseInt(fields[4]))
                .setAttributeBrand(Double.parseDouble(fields[5]))
                .setAttributePrice(Double.parseDouble(fields[6]))
                .setAttributePromotions(Double.parseDouble(fields[7]))
                .setAutoRenew(Boolean.parseBoolean(fields[8]))
                .setInertiaForSwitch(Integer.parseInt(fields[9]))
                .build();
    }
}
