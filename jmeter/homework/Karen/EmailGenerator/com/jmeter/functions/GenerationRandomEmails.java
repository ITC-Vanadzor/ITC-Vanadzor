package com.jmeter.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class GenerationRandomEmails extends AbstractFunction {

    private static final List<String> desc = new LinkedList<String>();
    private static final String KEY = "__GenerationRandomEmails";
    private static final int MAX_PARAM_COUNT = 0;
    private static final int MIN_PARAM_COUNT = 0;
    private Object[] values;

    static {
        desc.add("Generating random email adress.");
    }

    /**
     * No-arg constructor.
     */
    public GenerationRandomEmails() {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public synchronized String execute(SampleResult previousResult, Sampler currentSampler)
    throws InvalidVariableException {
    //JMeterVariables vars = getVariables();
    Random rand = new Random();
    String login = randomString(rand.nextInt(32),true);
    String server = randomString(rand.nextInt(7),false) + "."+ randomString(rand.nextInt(3)+1,false);
    String email = login + "@" + server;
    return String.valueOf(email);
    }

    String randomString( int len , boolean number) {
        if (len < 2){
            len = 2;
        }
        String AB = "abcdefghijklmnopqrstuvwxyz";
        if (number){
            AB = "abcdefghijklmnopqrstuvwxyz0123456789";
        }
        
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) 
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    /** {@inheritDoc} */
    @Override
    public synchronized void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        checkParameterCount(parameters, MIN_PARAM_COUNT, MAX_PARAM_COUNT);
        values = parameters.toArray();
    }

    /** {@inheritDoc} */
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }
}
