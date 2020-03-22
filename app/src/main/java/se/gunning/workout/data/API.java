package se.gunning.workout.data;

import java.util.List;
import se.gunning.workout.data.models.Workout;

public interface API {
  List<Workout> getWorkouts();
  void addWorkout(Workout workout);
}
