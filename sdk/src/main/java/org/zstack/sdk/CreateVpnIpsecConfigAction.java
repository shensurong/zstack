package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;
import org.zstack.sdk.*;

public class CreateVpnIpsecConfigAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    private static final HashMap<String, Parameter> nonAPIParameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public org.zstack.sdk.CreateVpnIpsecConfigResult value;

        public Result throwExceptionIfError() {
            if (error != null) {
                throw new ApiException(
                    String.format("error[code: %s, description: %s, details: %s]", error.code, error.description, error.details)
                );
            }
            
            return this;
        }
    }

    @Param(required = true, maxLength = 64, nonempty = false, nullElements = false, emptyString = false, noTrim = false)
    public java.lang.String name;

    @Param(required = false, validValues = {"disabled","group1","group2","group5","group14","group24"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String pfs = "group1";

    @Param(required = false, validValues = {"3des","aes-128","aes-192","aes-256","des"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String encAlg = "3des";

    @Param(required = false, validValues = {"md5","sha1"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String authAlg = "sha1";

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, numberRange = {60L,86400L}, noTrim = false)
    public java.lang.Integer lifetime = 86400;

    @Param(required = false, maxLength = 1024, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String description;

    @Param(required = false)
    public java.lang.String resourceUuid;

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = true)
    public String sessionId;

    @NonAPIParam
    public long timeout = -1;

    @NonAPIParam
    public long pollingInterval = -1;


    private Result makeResult(ApiResult res) {
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        org.zstack.sdk.CreateVpnIpsecConfigResult value = res.getResult(org.zstack.sdk.CreateVpnIpsecConfigResult.class);
        ret.value = value == null ? new org.zstack.sdk.CreateVpnIpsecConfigResult() : value; 

        return ret;
    }

    public Result call() {
        ApiResult res = ZSClient.call(this);
        return makeResult(res);
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                completion.complete(makeResult(res));
            }
        });
    }

    protected Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    protected Map<String, Parameter> getNonAPIParameterMap() {
        return nonAPIParameterMap;
    }

    protected RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "POST";
        info.path = "/hybrid/vpn-connection/ipsec";
        info.needSession = true;
        info.needPoll = true;
        info.parameterName = "params";
        return info;
    }

}
