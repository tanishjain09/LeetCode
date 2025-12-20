class BrowserHistory {
    private class DLL{
        String url;
        DLL next, prev;
        public DLL(String url){
            this.url = url;
            next = null;
            prev = null;
        }
    }
    DLL home;
    public BrowserHistory(String homepage) {
        home = new DLL(homepage);
    }
    
    public void visit(String url) {
        DLL node = new DLL(url);
        home.next = node;
        node.prev = home;
        home = node;
    }
    
    public String back(int steps) {
        while(home.prev!=null && steps-- > 0){
            home = home.prev;
        }
        return home.url;
    }
    
    public String forward(int steps) {
        while(home.next!=null && steps-- > 0){
            home = home.next;
        }
        return home.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */