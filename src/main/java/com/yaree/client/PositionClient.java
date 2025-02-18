package com.yaree.client;

import com.google.protobuf.Empty;
import com.yaree.proto.Position;
import com.yaree.proto.PositionServiceGrpc;
import io.grpc.ManagedChannelBuilder;

public class PositionClient {

  private final PositionServiceGrpc.PositionServiceBlockingStub stub;

  public PositionClient() {
    var managedChanel = ManagedChannelBuilder
        .forAddress(
            System.getProperty("position.client.host", "localhost"),
            Integer.parseInt(System.getProperty("position.client.port", "50051"))
        ).usePlaintext().build();
    this.stub = PositionServiceGrpc.newBlockingStub(managedChanel);
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
