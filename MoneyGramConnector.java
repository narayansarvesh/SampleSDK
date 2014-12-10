package com.mozido.moneygram.connector;

import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.mozido.connector.ConnectorBase;
import com.mozido.connector.ConnectorConfigurationException;
import com.mozido.moneygram.connector.network.MoneyGramAgentConnectNetworkService;
import com.mozido.moneygram.connector.operations.GetInformationOperation;

/**
 * com.mozido.moneygram.connector.MoneygramConnector is used to connect to
 * moneygram services.
 * 
 * @author rkela1
 */
@Component
@Scope("prototype")
public class MoneyGramConnector extends ConnectorBase<GetInformationOperation> {

	/**
	 * CONNECTOR_NAME contains the name of the connector.
	 */
	private static final String CONNECTOR_NAME = "MONEYGRAM_CONNECTOR";

	/**
	 * It contains a set of operation.
	 */
	@Autowired
	private Set<GetInformationOperation> operations;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mozido.connector.Connector#getName() gets the connector name
	 */
	@Override
	public String getName() {
		return CONNECTOR_NAME;
	}

	@Autowired
	private MoneyGramAgentConnectNetworkService networkService;

	/*
	 * This method initializes a soap driver instance from the connector
	 * configured parameters. (non-Javadoc)
	 * 
	 * @see com.mozido.connector.Connector#initialize(java.util.Map)
	 */
	@Override
	public void initialize(Map<String, String> parameters) throws ConnectorConfigurationException {
		this.parameters = parameters;
		networkService.init(parameters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mozido.connector.ConnectorBase#getOperations()
	 */
	@Override
	public Set<GetInformationOperation> getOperations() {
		return operations;
	}
}
