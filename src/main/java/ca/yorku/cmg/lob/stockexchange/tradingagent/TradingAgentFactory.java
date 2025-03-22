package ca.yorku.cmg.lob.stockexchange.tradingagent;

import ca.yorku.cmg.lob.stockexchange.StockExchange;
import ca.yorku.cmg.lob.stockexchange.events.NewsBoard;
import ca.yorku.cmg.lob.trader.Trader;

/*
    Concrete Class for TradingAgentFactory
 */
public class TradingAgentFactory extends  AbstractTradingAgentFactory{

    @Override
    public TradingAgent createAgent(String type, String style, Trader t, StockExchange exc, NewsBoard n){
        ITradingStrategy strategy;

        if(style.equalsIgnoreCase("Agressive")) {
            strategy = new TradingStrategyAggressive(t,exc);
        }else if(style.equalsIgnoreCase("Conservative")){
            strategy = new TradingStrategyConservative(t,exc);
        }else{
            throw new IllegalArgumentException("Invalid Trading Style: " + style);
        }

        if(type.equalsIgnoreCase("Institutional")){
            return new TradingAgentInstitutional(t,exc,n,strategy);
        }else if(type.equalsIgnoreCase("Retail")){
            return new TradingAgentRetail(t,exc,n,strategy);
        }else{
            throw new IllegalArgumentException("Invalid Agent Type: "+ type);
        }


    }
}
