package com.infinitasoftware.dickgen;

import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;

public class DickCommand implements CommandExecutor {
    private final Server server;

    public DickCommand( final Server server ) {
        this.server = server;
    }

    @Override
    public void execute( final String command, final CommandSender sender, final String[] args, final String label ) {
        if ( !sender.hasPermission( "dickworld.create" ) ) {
            sender.sendMessage( "You do not have permission to use /" + label );
            return;
        }

        if ( args.length != 1 ) {
            sender.sendMessage( "Usage: /" + label + " <worldname>" );
            return;
        }

        sender.sendMessage( "Creating new dick world..." );
        new Thread() {
            @Override
            public void run() {
                DickCommand.this.server.createWorld( args[ 0 ], 0L, new DickGenerator() );
                sender.sendMessage( "Finished creating dick world." );
            }
        }.start();
    }
}