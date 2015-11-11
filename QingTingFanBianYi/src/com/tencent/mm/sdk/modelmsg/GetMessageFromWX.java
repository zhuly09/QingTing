package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public final class GetMessageFromWX
{
  public static class Req extends BaseReq
  {
    public String country;
    public String lang;
    public String username;

    public Req()
    {
    }

    public Req(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public boolean checkArgs()
    {
      return true;
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.lang = paramBundle.getString("_wxapi_getmessage_req_lang");
      this.country = paramBundle.getString("_wxapi_getmessage_req_country");
    }

    public int getType()
    {
      return 3;
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_getmessage_req_lang", this.lang);
      paramBundle.putString("_wxapi_getmessage_req_country", this.country);
    }
  }

  public static class Resp extends BaseResp
  {
    private static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
    public WXMediaMessage message;

    public Resp()
    {
    }

    public Resp(Bundle paramBundle)
    {
      fromBundle(paramBundle);
    }

    public boolean checkArgs()
    {
      if (this.message == null)
      {
        a.a("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
        return false;
      }
      return this.message.checkArgs();
    }

    public void fromBundle(Bundle paramBundle)
    {
      super.fromBundle(paramBundle);
      this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    }

    public int getType()
    {
      return 3;
    }

    public void toBundle(Bundle paramBundle)
    {
      super.toBundle(paramBundle);
      paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    }
  }
}

/* Location:           C:\Users\User\dex2jar-2.0\dex\qting\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.modelmsg.GetMessageFromWX
 * JD-Core Version:    0.6.2
 */