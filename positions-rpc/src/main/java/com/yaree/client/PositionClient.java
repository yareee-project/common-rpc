package com.yaree.client;

import com.google.protobuf.Empty;
import com.yaree.proto.Position;
import com.yaree.proto.PositionServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class PositionClient {

  private final PositionServiceGrpc.PositionServiceBlockingStub stub;

  private PositionClient(String host, String port) {
    var managedChanel = ManagedChannelBuilder
        .forAddress(
            System.getProperty("position.client.host", host),
            Integer.parseInt(System.getProperty("position.client.port", port))
        ).usePlaintext().build();
    this.stub = PositionServiceGrpc.newBlockingStub(managedChanel);
  }

  public static PositionClient getPositionsClient(String host, Integer port) {
    return new PositionClient(host, port.toString());
  }

  public static PositionClient getPositionsClient() {
    return new PositionClient("localhost", "50051");
  }

  public Position.PositionResponse getPosition(Position.GetPositionRequest request) {
    return stub.getPosition(request);
  }

  public Position.PositionsResponse getPositions(Position.GetPositionsRequest request) {
    return stub.getPositions(request);
  }

  public Position.PositionResponse createPosition(Position.CreatePositionRequest request) {
    return stub.createPosition(request);
  }

  public Position.PositionResponse updatePosition(Position.UpdatePositionRequest request) {
    return stub.updatePosition(request);
  }

  public Empty deletePosition(Position.GetPositionRequest request) {
    return stub.deletePosition(request);
  }

}
