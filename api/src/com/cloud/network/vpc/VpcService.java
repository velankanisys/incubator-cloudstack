// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.network.vpc;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cloud.api.commands.ListPrivateGatewaysCmd;
import com.cloud.api.commands.ListStaticRoutesCmd;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.NetworkRuleConflictException;
import com.cloud.exception.ResourceAllocationException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.network.Network;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;

public interface VpcService {
    
    public VpcOffering getVpcOffering(long vpcOfferingId);
    
    public VpcOffering createVpcOffering(String name, String displayText, List<String> supportedServices);
    
    public Vpc getVpc(long vpcId);
    
    public Vpc getActiveVpc(long vpcId);
        
    public List<? extends Network> getVpcNetworks(long vpcId);
    
    Map<Service, Set<Provider>> getVpcOffSvcProvidersMap(long vpcOffId);
    
    List<? extends VpcOffering> listVpcOfferings(Long id, String name, String displayText, List<String> supportedServicesStr, 
            Boolean isDefault, String keyword, String state, Long startIndex, Long pageSizeVal);

    /**
     * @param offId
     * @return
     */
    public boolean deleteVpcOffering(long offId);

    /**
     * @param vpcOffId
     * @param vpcOfferingName
     * @param displayText
     * @param state
     * @return
     */
    public VpcOffering updateVpcOffering(long vpcOffId, String vpcOfferingName, String displayText, String state);

    /**
     * @param zoneId
     * @param vpcOffId
     * @param vpcOwnerId
     * @param vpcName
     * @param displayText
     * @param cidr
     * @param networkDomain TODO
     * @return
     */
    public Vpc createVpc(long zoneId, long vpcOffId, long vpcOwnerId, String vpcName, String displayText, String cidr, String networkDomain);

    /**
     * @param vpcId
     * @return
     * @throws InsufficientCapacityException 
     * @throws ResourceUnavailableException 
     * @throws ConcurrentOperationException 
     */
    public boolean deleteVpc(long vpcId) throws ConcurrentOperationException, ResourceUnavailableException;

    /**
     * @param vpcId
     * @param vpcName
     * @param displayText
     * @return
     */
    public Vpc updateVpc(long vpcId, String vpcName, String displayText);

    /**
     * @param id
     * @param vpcName
     * @param displayText
     * @param supportedServicesStr
     * @param cidr
     * @param state TODO
     * @param accountName
     * @param domainId
     * @param keyword
     * @param startIndex
     * @param pageSizeVal
     * @param zoneId TODO
     * @param isRecursive TODO
     * @param listAll TODO
     * @param restartRequired TODO
     * @param vpc
     * @return
     */
    public List<? extends Vpc> listVpcs(Long id, String vpcName, String displayText, 
            List<String> supportedServicesStr, String cidr, Long vpcOffId, String state, String accountName, Long domainId,
            String keyword, Long startIndex, Long pageSizeVal, Long zoneId, Boolean isRecursive, Boolean listAll, 
            Boolean restartRequired);

    /**
     * @param vpcId
     * @return
     * @throws InsufficientCapacityException 
     * @throws ResourceUnavailableException 
     * @throws ConcurrentOperationException 
     */
    boolean startVpc(long vpcId) throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException;

    /**
     * @param vpcId
     * @return
     * @throws ConcurrentOperationException
     * @throws ResourceUnavailableException
     */
    boolean shutdownVpc(long vpcId) throws ConcurrentOperationException, ResourceUnavailableException;

    /**
     * @param id
     * @return
     * @throws InsufficientCapacityException 
     */
    boolean restartVpc(long id) throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException;
    
    PrivateGateway getVpcPrivateGateway(long id);

    /**
     * @param vpcId TODO
     * @param physicalNetworkId
     * @param vlan
     * @param ipAddress
     * @param gateway
     * @param netmask
     * @param gatewayOwnerId
     * @return
     * @throws InsufficientCapacityException 
     * @throws ConcurrentOperationException 
     * @throws ResourceAllocationException 
     */
    public PrivateGateway createVpcPrivateGateway(long vpcId, Long physicalNetworkId, String vlan, String ipAddress, 
            String gateway, String netmask, long gatewayOwnerId) throws ResourceAllocationException, 
            ConcurrentOperationException, InsufficientCapacityException;

    /**
     * @param gatewayId
     * @return
     * @throws ResourceUnavailableException 
     * @throws ConcurrentOperationException 
     */
    public PrivateGateway applyVpcPrivateGateway(Long gatewayId) throws ConcurrentOperationException, ResourceUnavailableException;
    
    /**
     * @param id
     * @return
     * @throws ResourceUnavailableException 
     * @throws ConcurrentOperationException 
     */
    boolean deleteVpcPrivateGateway(Long gatewayId) throws ConcurrentOperationException, ResourceUnavailableException;

    /**
     * @param listPrivateGatewaysCmd
     * @return
     */
    public List<PrivateGateway> listPrivateGateway(ListPrivateGatewaysCmd listPrivateGatewaysCmd);

    /**
     * @param routeId
     * @return
     */
    StaticRoute getStaticRoute(long routeId);

    /**
     * @param vpcId
     * @return
     * @throws ResourceUnavailableException 
     */
    public boolean applyStaticRoutes(long vpcId) throws ResourceUnavailableException;

    /**
     * @param routeId
     * @return TODO
     * @throws ResourceUnavailableException 
     */
    public boolean revokeStaticRoute(long routeId) throws ResourceUnavailableException;

    /**
     * @param gatewayId
     * @param cidr
     * @return
     */
    public StaticRoute createStaticRoute(long gatewayId, String cidr) throws NetworkRuleConflictException;

    /**
     * @param listStaticRoutesCmd
     * @return
     */
    public List<? extends StaticRoute> listStaticRoutes(ListStaticRoutesCmd cmd);

    /**
     * @param id
     * @return
     */
    VpcGateway getVpcGateway(long id);

}