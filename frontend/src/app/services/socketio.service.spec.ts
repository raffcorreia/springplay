import { TestBed } from '@angular/core/testing';

import { SocketIOService } from './socketio.service';

describe('SocketioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SocketIOService = TestBed.get(SocketIOService);
    expect(service).toBeTruthy();
  });
});
