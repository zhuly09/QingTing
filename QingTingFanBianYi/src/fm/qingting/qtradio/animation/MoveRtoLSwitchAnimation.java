package fm.qingting.qtradio.animation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import fm.qingting.framework.view.IView;

public class MoveRtoLSwitchAnimation extends MoveLtoRSwitchAnimation
{
  protected void doAnimation()
  {
    try
    {
      this.openedView.getView().clearAnimation();
      this.closedView.getView().clearAnimation();
      this.openedView.getView().setVisibility(0);
      this.closedView.getView().setVisibility(0);
      this.openedView.addViewEventListener(this);
      this.container.bringChildToFront(this.openedView.getView());
      this.openedView.setOpenAnimation(getOpenAnimation());
      this.container.getChildCount();
      this.openedView.open(true);
      this.closedView.close(false);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected Animation getOpenAnimation()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(this.container.getWidth(), 0.0F, 0.0F, 0.0F);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(350L);
    return localTranslateAnimation;
  }

  public void viewDidClosed(IView paramIView)
  {
  }

  public void viewDidOpened(IView paramIView)
  {
    this.openedView.removeViewEventListener(this);
    animationEnd();
  }
}

/* Location:           C:\Users\User\dex2jar-2.0\dex\qting\classes-dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.animation.MoveRtoLSwitchAnimation
 * JD-Core Version:    0.6.2
 */