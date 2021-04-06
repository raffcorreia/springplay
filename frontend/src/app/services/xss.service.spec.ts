import {TestBed} from '@angular/core/testing';

import {XssService} from './xss.service';

describe('XssService', () => {
    beforeEach(() => TestBed.configureTestingModule({}));

    it('should be created', () => {
        const service: XssService = TestBed.get(XssService);
        expect(service).toBeTruthy();
    });
});
