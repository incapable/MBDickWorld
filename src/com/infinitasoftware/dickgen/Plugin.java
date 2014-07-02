package com.infinitasoftware.dickgen;

import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;

@Manifest( name = "DickWorld" )
public class Plugin extends MBServerPlugin {
    @Override
    public void onEnable() {
        this.getPluginManager().registerCommand( "dickworld", new String[] { "dw", "dickify" }, new DickCommand( this.getServer() ) );
    }
}