package hello.core.lifecycle;


public class NetworkClient {

  private String url;

  public NetworkClient() {
    System.out.println("url = " + url);

  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void connect() {
    System.out.println("connect: " + url);
  }

  public void call(String message) {
    System.out.println("call: " + url + " message = " + message);
  }

  public void disconnect() {
    System.out.println("disconnect: " + url);
  }

  public void init() throws Exception {
    System.out.println("NetworkClient.init");
    connect();
    call(url);
  }

  public void close() throws Exception {
    System.out.println("NetworkClient.close");
    disconnect();
  }
}
