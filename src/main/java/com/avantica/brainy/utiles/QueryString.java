package com.avantica.brainy.utiles;

import com.avantica.brainy.enums.AuthorizeParametersEnum;
import com.avantica.brainy.model.ParametersEnum;

import java.util.HashMap;
import java.util.Map;


public class QueryString {
	
	private Map<String,String> parameters;
	private String domain;
	
	private QueryString(){
		parameters = new HashMap<>();
	}
	
	private QueryString(String domain){
		this();
		this.domain = domain;
	}
	
	public static QueryString withDomain(String domain){
		return new QueryString(domain);
	}
	
	public QueryString andParameter(ParametersEnum outLookPameter){
		parameters.put(outLookPameter.getCodigo(), outLookPameter.getDescripcion());
		return this;
	}

    public QueryString andParameter(AuthorizeParametersEnum authorizeParametersEnum){
        parameters.put(authorizeParametersEnum.getParameterCode(), authorizeParametersEnum.getParameterValue());
        return this;
    }

    public QueryString andParameter(String code, String value){
        parameters.put(code, value);
        return this;
    }

	public QueryString andParameterValue(ParametersEnum outLookPameter, String value){
		parameters.put(value, outLookPameter.getDescripcion());
		return this;
	}
	
	public String giveMeURL(){
		StringBuilder finalUrl = new StringBuilder();
		finalUrl.append(domain+"?");
		for(String key: parameters.keySet()){
			finalUrl.append(buildParameter(parameters.get(key),key));
		}
		return finalUrl.toString();
	}
	
	private String buildParameter(String code, String value){
		return code.concat("=").concat(value).concat("&");
	}
}