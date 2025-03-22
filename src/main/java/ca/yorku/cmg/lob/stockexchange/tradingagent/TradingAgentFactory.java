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
        ITradingStrategy strat;

        if(style.equalsIgnoreCase("Aggressive")) {
            strat = new TradingStrategyAggressive(t,exc);
        }else if(style.equalsIgnoreCase("Conservative")){
            strat = new TradingStrategyConservative(t,exc);
        }else{
            throw new IllegalArgumentException("Invalid Trading Style: " + style);
        }

        if(type.equalsIgnoreCase("Institutional")){
            return new TradingAgentInstitutional(t,exc,n,strat);
        }else if(type.equalsIgnoreCase("Retail")){
            return new TradingAgentRetail(t,exc,n,strat);
        }else{
            throw new IllegalArgumentException("Invalid Agent Type: "+ type);
        }


    }
}
