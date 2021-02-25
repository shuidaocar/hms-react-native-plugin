/*
    Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License")
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        https://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.huawei.hms.rn.ml.helpers.transactors;

import com.facebook.react.bridge.ReactApplicationContext;
import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.face.face3d.ML3DFace;
import com.huawei.hms.rn.ml.helpers.creators.HMSResultCreator;
import com.huawei.hms.rn.ml.helpers.utils.HMSUtils;

import static com.huawei.hms.rn.ml.helpers.constants.HMSConstants.FACE_3D_TRANSACTOR_ON_DESTROY;
import static com.huawei.hms.rn.ml.helpers.constants.HMSConstants.FACE_3D_TRANSACTOR_ON_RESULT;

public class HMS3DFaceAnalyzerTransactor extends HMSBaseTransactor implements MLAnalyzer.MLTransactor<ML3DFace> {

    public HMS3DFaceAnalyzerTransactor(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public void destroy() {
        sendEvent(FACE_3D_TRANSACTOR_ON_DESTROY, "destroy", null);
    }

    @Override
    public void transactResult(MLAnalyzer.Result<ML3DFace> result) {
        sendEvent(FACE_3D_TRANSACTOR_ON_RESULT, "transactResult", HMSResultCreator.getInstance().get3DFaceResult(HMSUtils.getInstance().convertSparseArrayToList(result.getAnalyseList())));
    }
}