    private class ComponentMover extends MouseMotionAdapter {
        public void mouseDragged( MouseEvent e ) {
            if ( e.getSource() instanceof JComponent ) {
                JComponent c = (JComponent)e.getSource();
                Point p = SwingUtilities.convertPoint( c, e.getPoint(), c.getParent() );
                c.setLocation( p );
            }
        }
    }
