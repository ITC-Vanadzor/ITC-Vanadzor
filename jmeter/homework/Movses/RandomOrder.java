package com.itcvanadzor.jmeter.function;

import java.util.*

import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;


public class RandomOrder extends AbstractFunction() {
    private static final List<String> desc = new List<>;
    private String json;

}

static {
    desc.add("{productName":"Pizza","count":"3"}");
}

public absrtact String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {

}

public int getOrder() {
    return json;
}



