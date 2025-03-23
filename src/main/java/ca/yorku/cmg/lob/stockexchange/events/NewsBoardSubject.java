package ca.yorku.cmg.lob.stockexchange.events;

import ca.yorku.cmg.lob.stockexchange.tradingagent.INewsObserver;

public interface NewsBoardSubject {
    public void registerObserver(INewsObserver o);
    public void removeObserver(INewsObserver o);
    public void notifyObservers(Event e);
}
