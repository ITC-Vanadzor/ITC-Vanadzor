package com.itcvanadzor.jmeter.functions;

import java.util.LinkedList;
import java.util.List;
import java.util.Collection;

import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.engine.util.CompoundVariable;

public class RandomEmailGenerator extends AbstractFunction {

    private static final List<String> desc = new LinkedList<String>();
    private static final String referenceKey = "__RandomEmail";
    private String name;
    private String server;

    static {
        desc.add("Name");
        desc.add("Server");
    }

    /** {@inheritDoc} */
    @Override
        public synchronized String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
            return name + "@" + server; 
        }
    
    /** {@inheritDoc} */
    @Override
        public synchronized void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
            Object[] values = parameters.toArray();
            name = ((CompoundVariable) values[0]).execute();
            server = ((CompoundVariable) values[1]).execute();
        }

    /** ${@inheritDoc} */
    @Override
        public String getReferenceKey() {
            return referenceKey;
        }

    @Override
        public List<String> getArgumentDesc() {
            return desc;
        }

}
