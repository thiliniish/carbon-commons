/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.redirector.servlet.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.framework.BundleContext;
import org.wso2.carbon.registry.core.service.RegistryService;
import org.wso2.carbon.user.core.service.RealmService;
import org.wso2.carbon.activation.service.ActivationService;
import org.wso2.carbon.redirector.servlet.util.Util;

/**
 * @scr.component name="org.wso2.carbon.redirector.servlet"
 * immediate="true"
 * @scr.reference name="registry.service"
 * interface="org.wso2.carbon.registry.core.service.RegistryService" cardinality="1..1"
 * policy="dynamic" bind="setRegistryService" unbind="unsetRegistryService"
 * @scr.reference name="user.realmservice.default" interface="org.wso2.carbon.user.core.service.RealmService"
 * cardinality="1..1" policy="dynamic" bind="setRealmService"
 * unbind="unsetRealmService"
 * @scr.reference name="activation.service" interface="org.wso2.carbon.activation.service.ActivationService"
 * cardinality="0..1" policy="dynamic" bind="setActivationService"
 * unbind="unsetActivationService"
 */
public class RedirectorServletServiceComponent {
     private static Log log = LogFactory.getLog(RedirectorServletServiceComponent.class);

    protected void activate(ComponentContext context) {
        try {
            log.debug("******* Multitenancy Redirector Servlet admin service bundle is activated ******* ");
        } catch (Exception e) {
            log.error("******* Multitenancy Redirector Servlet admin service bundle failed activating ****", e);
        }
    }

    protected void deactivate(ComponentContext context) {
        log.debug("******* Multitenancy Redirector Servlet admin service bundle is deactivated ******* ");
    }

    protected void setRegistryService(RegistryService registryService) {
        Util.setRegistryService(registryService);
    }

    protected void unsetRegistryService(RegistryService registryService) {
        Util.setRegistryService(null);
    }

    protected void setRealmService(RealmService realmService) {
        Util.setRealmService(realmService);
    }

    protected void unsetRealmService(RealmService realmService) {
        Util.setRealmService(null);
    }

    protected void setActivationService(ActivationService activationService) {
        Util.setActivationService(activationService);
    }

    protected void unsetActivationService(ActivationService activationService) {
        Util.setActivationService(null);
    }
}
