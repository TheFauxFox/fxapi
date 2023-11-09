package paw.faux.fx.events;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import paw.faux.fx.abstracts.Event;

public class EventRenderWorld extends Event {
    public MatrixStack matrices;
    public float tickDelta;
    public long limitTime;
    public boolean renderBlockOutline;
    public Camera camera;
    public GameRenderer gameRenderer;
    public LightmapTextureManager lightmapTextureManager;
    public Matrix4f projectionMatrix;

    public EventRenderWorld(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f projectionMatrix) {
        this.matrices = matrices;
        this.tickDelta = tickDelta;
        this.limitTime = limitTime;
        this.renderBlockOutline = renderBlockOutline;
        this.camera = camera;
        this.gameRenderer = gameRenderer;
        this.lightmapTextureManager = lightmapTextureManager;
        this.projectionMatrix = projectionMatrix;
    }

    public static class PRE extends EventRenderWorld {
        public PRE(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f projectionMatrix) {
            super(matrices, tickDelta, limitTime, renderBlockOutline, camera, gameRenderer, lightmapTextureManager, projectionMatrix);
        }
    }

    public static class POST extends EventRenderWorld {
        public POST(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f projectionMatrix) {
            super(matrices, tickDelta, limitTime, renderBlockOutline, camera, gameRenderer, lightmapTextureManager, projectionMatrix);
        }
    }
}
