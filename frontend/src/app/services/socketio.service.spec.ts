import { TestBed } from '@angular/core/testing';

import { SocketioNodeService } from './socketio.service';

describe('SocketioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SocketioNodeService = TestBed.get(SocketioNodeService);
    expect(service).toBeTruthy();
  });
});
