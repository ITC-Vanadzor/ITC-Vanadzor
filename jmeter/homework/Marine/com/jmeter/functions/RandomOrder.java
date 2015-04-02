package com.jmeter.functions;

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import org.json.simple.JSONObject;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class RandomOrder extends AbstractFunction {

    private static final List<String> desc = new LinkedList<String>();
    private static final String KEY = "__RandomOrder";
    private Object[] values;
    private int sessionId;
    private int placeId;
    private int productId;
    private int count;

    static {
        desc.add("SessionId");
        desc.add("PlaceId");
        desc.add("ProductId");
        desc.add("ProductCount");
    }

    /**
     *      * No-arg constructor.
     *           */
    public RandomOrder() {
        super();
    }


    /** {@inheritDoc} */
    @Override
    public synchronized String execute(SampleResult previousResult, Sampler currentSampler)
    throws InvalidVariableException {
    Random rand = new Random();
    JSONObject resultJson = new JSONObject();
    sessionId = rand.nextInt(25);
    resultJson.put("sessionId", sessionId);
    placeId = rand.nextInt(5);
    resultJson.put("placeId", placeId);
    productId = rand.nextInt(10);
    resultJson.put("productId", productId);
    count = rand.nextInt(10);
    resultJson.put("count", count);
    return  resultJson.toString();
    }
    /** {@inheritDoc} */
    @Override
    public synchronized void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
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
