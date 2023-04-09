package iut.uca.projet.fragment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import iut.uca.projet.R
import iut.uca.projet.model.MemoryGame

class FragmentBall :  Fragment(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var gyroscopeSensor: Sensor
    private lateinit var ballView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ballview, container, false)

        // Get the BallView from the layout
        ballView = view.findViewById(R.id.ballView)

        // Get the SensorManager and the gyroscope sensor
        sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        return view
    }

    override fun onResume() {
        super.onResume()

        // Register the gyroscope sensor listener
        sensorManager.registerListener(
            this, gyroscopeSensor, SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onPause() {
        super.onPause()

        // Unregister the gyroscope sensor listener
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            // Update the ball position using the gyroscope values
            val dx = event.values[1] * 20f
            val dy = event.values[0] * 20f

            // Get the dimensions of the parent view
            val parentView = ballView.parent as View
            val parentWidth = parentView.width
            val parentHeight = parentView.height

            // Calculate the new position of the ball
            var newX = ballView.x + dx
            var newY = ballView.y + dy

            // Check if the new position is within the parent view's bounds
            if (newX < 0) newX = 0f
            if (newY < 0) newY = 0f
            if (newX > parentWidth - ballView.width) newX = parentWidth - ballView.width.toFloat()
            if (newY > parentHeight - ballView.height) newY = parentHeight - ballView.height.toFloat()

            // Update the position of the ball
            ballView.x = newX
            ballView.y = newY
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not used
    }
}
