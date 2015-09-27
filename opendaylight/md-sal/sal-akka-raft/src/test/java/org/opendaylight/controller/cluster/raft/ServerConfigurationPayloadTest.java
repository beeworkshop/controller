/*
 * Copyright (c) 2015 Brocade Communications Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.cluster.raft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

/**
 * Unit tests for ServerConfigurationPayload.
 *
 * @author Thomas Pantelis
 */
public class ServerConfigurationPayloadTest {

    @Test
    public void testSerialization() {
        ServerConfigurationPayload expected = new ServerConfigurationPayload(Arrays.asList("1", "2"),
                Arrays.asList("3"));
        ServerConfigurationPayload cloned = (ServerConfigurationPayload) SerializationUtils.clone(expected);

        assertEquals("getNewServerConfig", expected.getNewServerConfig(), cloned.getNewServerConfig());
        assertEquals("getOldServerConfig", expected.getOldServerConfig(), cloned.getOldServerConfig());
    }

    @Test
    public void testSize() {
        ServerConfigurationPayload expected = new ServerConfigurationPayload(Arrays.asList("1", "2"),
                Arrays.asList("3"));
        assertTrue(expected.size() > 0);
    }
}
